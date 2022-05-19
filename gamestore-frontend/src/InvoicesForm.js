import { useState } from "react";

function InvoicesForm({ invoices: initialInvoices, notify }) {
  const [invoices, setInvoices] = useState(initialInvoices);
  const isAdd = initialInvoices.id === 0;

  function handleChange(evt) {
    const clone = { ...invoices };
    clone[evt.target.name] = evt.target.value;
    setInvoices(clone);
  }

  function handleSubmit(evt) {
    evt.preventDefault();

    const url = isAdd
      ? "http://localhost:8080/invoices"
      : `http://localhost:8080/invoices/${invoices.id}`;
    const method = isAdd ? "POST" : "PUT";
    const expectedStatus = isAdd ? 201 : 204;

    const init = {
      method,
      headers: {
        "Content-Type": "application/json",
        Accept: "application/json",
      },
      body: JSON.stringify(invoices),
    };

    fetch(url, init)
      .then((response) => {
        if (response.status === expectedStatus) {
          if (isAdd) {
            return response.json();
          } else {
            return invoices;
          }
        }
        return Promise.reject(
          `Didn't receive expected status: ${expectedStatus}`
        );
      })
      .then((result) =>
        notify({
          action: isAdd ? "add" : "edit",
          invoices: result,
        })
      )
      .catch((error) => notify({ error: error }));
  }

  return (
    <>
      <h1>{invoices.id > 0 ? "Edit" : "Add"} Invoices</h1>
      <form onSubmit={handleSubmit}>
        <div className="mb-3">
          <label htmlFor="name">Name</label>
          <input
            type="text"
            id="name"
            name="ne"
            className="form-control"
            value={invoices.name}
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
            value={invoices.street}
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
            value={invoices.city}
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
            value={invoices.state}
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
            value={invoices.zip}
            onChange={handleChange}
          />
        </div>
        <div className="mb-3">
          <label htmlFor="itemType">Item Type</label>
          <select id="itemType" name="itemType">
            <optgroup label="Consoles">
              <option> Nintendo Wii</option>
              <option> Xbox</option>
              <option> Playstation</option>
            </optgroup>
            <optgroup label="Games">
              <option> Final Fantasy</option>
              <option> Call of Duty</option>
              <option> Time Crisis</option>
            </optgroup>
            <optgroup label="Tshirts">
              <option> red</option>
              <option> blue</option>
              <option> black</option>
            </optgroup>
          </select>
        </div>
        <div className="mb-3">
          <label htmlFor="quantity">Quantity</label>
          <input
            type="text"
            id="quantity"
            name="quantity"
            className="form-control"
            value={invoices.quantity}
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

export default InvoicesForm;
