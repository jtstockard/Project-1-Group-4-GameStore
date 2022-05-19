import { useState, useEffect } from "react";
// import "./Card.css";
import InvoiceCard from "./InvoiceCard.js";
import InvoicesForm from "./InvoicesForm.js";

function Invoices() {
  const [invoices, setInvoices] = useState([]);
  const [showForm, setShowForm] = useState(false);
  const [scopedInvoices, setScopedInvoices] = useState({});
  const [error, setError] = useState();

  useEffect(() => {
    fetch("http://localhost:8080/invoices")
      .then((response) => {
        console.log(response);
        return response.json();
      })
      .then((result) => setInvoices(result))
      .catch(console.log);
  }, []);

  function addClick() {
    // const now = new Date();
    setScopedInvoices({
      id: 0,
      name: "",
      street: "",
      city: "",
      state: "",
      zipCode: "",
      itemType: "",
      itemId: "",
      unitPrice: "",
      subTotal: "",
      taxTotal: "",
      processing: "",
      quantity: "",
      total: "",
    });
    setShowForm(true);
  }

  function notify({ action, invoices: invoicesAdd, error }) {
    if (error) {
      setError(error);
      setShowForm(false);
      return;
    }

    switch (action) {
      case "add":
        setInvoices([...invoices, invoicesAdd]);
        break;
      case "edit":
        setInvoices(
          invoices.map((e) => {
            if (e.id === invoicesAdd.id) {
              return invoices;
            }
            return e;
          })
        );
        break;
      case "edit-form":
        setScopedInvoices(invoicesAdd);
        setShowForm(true);
        return;
      case "delete":
        setInvoices(invoices.filter((e) => e.id !== invoicesAdd.id));
        break;
      default:
        console.log("You have entered an invalid choice! Try again!");
        break;
    }

    setError("");
    setShowForm(false);
  }

  if (showForm) {
    return <InvoicesForm invoices={scopedInvoices} notify={notify} />;
  }

  return (
    <>
      {error && <div className="alert alert-danger">{error}</div>}
      <div>
        <h1 id="invoicesTitle">Invoices</h1>
        <button className="btn btn-primary" type="button" onClick={addClick}>
          Add a Invoices
        </button>
        <table id="invoices">
          <tr>
            <th>Name</th>
            <th>Street</th>
            <th>City</th>
            <th>State</th>
            <th>Zip</th>
            <th>itemType</th>
            <th>itemId</th>
            <th>unitPrice</th>
            <th>subTotal</th>
            <th>taxTotal</th>
            <th>processing</th>
            <th>quantity</th>
            <th>total</th>
          </tr>
          <tbody>
            {invoices.map((r) => (
              <InvoiceCard key={r.id} invoices={r} notify={notify} />
            ))}
          </tbody>
        </table>
      </div>
    </>
  );
}

export default Invoices;
