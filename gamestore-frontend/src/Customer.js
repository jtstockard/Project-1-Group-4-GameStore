import { useState, useEffect } from "react";
// import "./Customer.css";
import CustomerCard from "./CustomerCard.js";
// import CustomerForm from "./CustomerForm.js";
import ConsolesCard from "./ConsolesCard.js";
import GamesCard from "./GamesCard.js";
import InvoiceCard from "./InvoiceCard";
import OrderForm from "./OrderForm.js";
import TshirtsCard from "./TshirtsCard.js";

function Customers() {
  const [customers, setCustomers] = useState([]);
  const [showForm, setShowForm] = useState(false);
  const [scopedCustomer, setScopedCustomer] = useState({});
  const [error, setError] = useState();

  useEffect(() => {
    fetch("http://localhost:8080/customer")
      .then((response) => response.json())
      .then((result) => setCustomers(result))
      .catch(console.log);
  }, []);

  function addClick() {
    // const now = new Date();
    setScopedCustomer({
      id: 0,
      firstName: "",
      lastName: "",
      street: "",
      city: "",
      state: "",
      zip: "",
      level: "",
    });
    setShowForm(true);
  }

  function notify({ action, customer, error }) {
    if (error) {
      setError(error);
      setShowForm(false);
      return;
    }

    switch (action) {
      case "add":
        setCustomers([...customers, customer]);
        break;
      case "edit":
        setCustomers(
          customers.map((e) => {
            if (e.id === customer.id) {
              return customer;
            }
            return e;
          })
        );
        break;
      case "edit-form":
        setScopedCustomer(customer);
        setShowForm(true);
        return;
      case "delete":
        setCustomers(customers.filter((e) => e.id !== customer.id));
        break;
      default:
        console.log("You have entered an invalid choice! Try again!");
        break;
    }

    setError("");
    setShowForm(false);
  }

  if (showForm) {
    return <OrderForm customer={scopedCustomer} notify={notify} />;
  }

  return (
    <>
      {error && <div className="alert alert-danger">{error}</div>}
      <div>
        <h1 id="customerTitle">Customers</h1>
        <button className="btn btn-primary" type="button" onClick={addClick}>
          Place an Order
        </button>
        <table id="customers">
          <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Street</th>
            <th>City</th>
            <th>State</th>
            <th>Zip</th>
            <th>Level</th>
          </tr>
          <tbody>
            {customers.map((r) => (
              <CustomerCard key={r.customerId} customer={r} notify={notify} />
            ))}
          </tbody>
        </table>
      </div>
    </>
  );
}

export default Customers;
