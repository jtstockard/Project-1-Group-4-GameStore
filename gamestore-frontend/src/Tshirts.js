import { useState, useEffect } from "react";
import "./Card.css";
import TshirtsCard from "./TshirtsCard.js";
import TshirtsForm from "./TshirtsForm.js";

function Tshirts() {
  const [tshirts, setTshirts] = useState([]);
  const [showForm, setShowForm] = useState(false);
  const [scopedCustomer, setScopedCustomer] = useState({});
  const [error, setError] = useState();

  useEffect(() => {
    fetch("http://localhost:8080/tshirts")
      .then((response) => response.json())
      .then((result) => setTshirts(result))
      .catch(console.log);
  }, []);

  function addClick() {
    // const now = new Date();
    setScopedCustomer({
      id: 0,
      size: "",
      color: "",
      description: "",
      price: "",
      quantity: "",
    });
    setShowForm(true);
  }

  function notify({ action, tshirts, error }) {
    if (error) {
      setError(error);
      setShowForm(false);
      return;
    }

    switch (action) {
      case "add":
        setTshirts([...tshirts, tshirts]);
        break;
      case "edit":
        setTshirts(
          tshirts.map((e) => {
            if (e.id === tshirts.id) {
              return tshirts;
            }
            return e;
          })
        );
        break;
      case "edit-form":
        setScopedCustomer(tshirts);
        setShowForm(true);
        return;
      case "delete":
        setTshirts(tshirts.filter((e) => e.id !== tshirts.id));
        break;
      default:
        console.log("You have entered an invalid choice! Try again!");
        break;
    }

    setError("");
    setShowForm(false);
  }

  if (showForm) {
    return <TshirtsForm tshirts={scopedCustomer} notify={notify} />;
  }

  return (
    <>
      {error && <div className="alert alert-danger">{error}</div>}
      <div>
        <h1 id="customerTitle">Tshirts</h1>
        <button className="btn btn-primary" type="button" onClick={addClick}>
          Add a Tshirts
        </button>
        <table id="tshirts">
          <tr>
            <th>size</th>
            <th>color</th>
            <th>description</th>
            <th>price</th>
            <th>quantity</th>
          </tr>
          <tbody>
            {tshirts.map((r) => (
              <TshirtsCard key={r.customerId} tshirts={r} notify={notify} />
            ))}
          </tbody>
        </table>
      </div>
    </>
  );
}

export default Tshirts;
