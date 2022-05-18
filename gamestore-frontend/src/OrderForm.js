import { useState } from "react";

import CustomerCard from "./CustomerCard.js";
// import CustomerForm from "./CustomerForm.js";
import ConsolesCard from "./ConsolesCard.js";
import GamesCard from "./GamesCard.js";
import InvoiceCard from "./InvoiceCard";
import TshirtsCard from "./TshirtsCard.js";

function OrderForm({ customer: initialCustomer, notify }) {
  const [customer, setCustomer] = useState(initialCustomer);
  const isAdd = initialCustomer.id === 0;

  function handleChange(evt) {
    const clone = { ...customer };
    clone[evt.target.name] = evt.target.value;
    setCustomer(clone);
  }

  function handleSubmit(evt) {
    evt.preventDefault();

    const url = isAdd
      ? "http://localhost:8080/customer"
      : `http://localhost:8080/customer/${customer.id}`;
    const method = isAdd ? "POST" : "PUT";
    const expectedStatus = isAdd ? 201 : 204;

    const init = {
      method,
      headers: {
        "Content-Type": "application/json",
        Accept: "application/json",
      },
      body: JSON.stringify(customer),
    };

    fetch(url, init)
      .then((response) => {
        if (response.status === expectedStatus) {
          if (isAdd) {
            return response.json();
          } else {
            return customer;
          }
        }
        return Promise.reject(
          `Didn't receive expected status: ${expectedStatus}`
        );
      })
      .then((result) =>
        notify({
          action: isAdd ? "add" : "edit",
          customer: result,
        })
      )
      .catch((error) => notify({ error: error }));
  }

  return (
    <>
      <h1>{customer.id > 0 ? "Edit" : "Add"} Order</h1>
      <form onSubmit={handleSubmit}>
        <div className="mb-3">
          <label htmlFor="firstName">Name</label>
          <input
            type="text"
            id="name"
            name="ne"
            className="form-control"
            value={customer.name}
            onChange={handleChange}
          />
        </div>
        <div className="mb-3">
          <label htmlFor="street">Street</label>
          <input
            type="text"
            id="street"
            name="street"
            className="form-control"
            value={customer.street}
            onChange={handleChange}
          />
        </div>
        <div className="mb-3">
          <label htmlFor="city">City</label>
          <input
            type="text"
            id="city"
            name="city"
            className="form-control"
            value={customer.city}
            onChange={handleChange}
          />
        </div>
        <div className="mb-3">
          <label htmlFor="state">State</label>
          <input
            type="text"
            id="state"
            name="state"
            className="form-control"
            value={customer.state}
            onChange={handleChange}
          />
        </div>

        <div className="mb-3">
          <label htmlFor="zip">Zip</label>
          <input
            type="text"
            id="zip"
            name="zip"
            className="form-control"
            value={customer.zip}
            onChange={handleChange}
          />
        </div>
        <div className="mb-3">
          <label htmlFor="itemType">Item Type</label>
          <input
            type="text"
            id="itemType"
            name="itemType"
            className="form-control"
            value={customer.itemType}
            onChange={handleChange}
          />
        </div>
        <div className="mb-3">
          <label htmlFor="itemId">Item Id</label>
          <input
            type="text"
            id="itemId"
            name="itemId"
            className="form-control"
            value={customer.itemId}
            onChange={handleChange}
          />
        </div>
        <div className="mb-3">
          <label htmlFor="quantity">Quantity</label>
          <input
            type="text"
            id="quantity"
            name="quantity"
            className="form-control"
            value={customer.quantity}
            onChange={handleChange}
          />
        </div>

        <div className="mb-3">
          <button className="btn btn-primary mr-3" type="submit">
            Save
          </button>
          <button
            className="btn btn-secondary"
            type="button"
            onClick={() => notify({ action: "cancel" })}
          >
            Cancel
          </button>
        </div>
      </form>
    </>
  );
}

export default OrderForm;
