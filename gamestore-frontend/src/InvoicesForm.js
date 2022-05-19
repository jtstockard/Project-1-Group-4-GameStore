import { useState, useEffect } from "react";
// import tshirts from "./Tshirts";
// import consoles from "./Consoles";
// import games from "./Games";

function InvoicesForm({ invoices: initialInvoices, notify }) {
  const [invoices, setInvoices] = useState(initialInvoices);
  const isAdd = initialInvoices.id === 0;
  const [tshirts, setTshirts] = useState([]);
  const [consoles, setConsoles] = useState([]);
  const [games, setGames] = useState([]);

  useEffect(() => {
    fetch("http://localhost:8080/games")
      .then((response) => {
        console.log(response);
        return response.json();
      })
      .then((result) => setGames(result))
      .catch(console.log);
  }, []);

  useEffect(() => {
    fetch("http://localhost:8080/consoles")
      .then((response) => {
        console.log(response);
        return response.json();
      })
      .then((result) => setConsoles(result))
      .catch(console.log);
  }, []);

  useEffect(() => {
    fetch("http://localhost:8080/tshirts")
      .then((response) => {
        console.log(response);
        return response.json();
      })
      .then((result) => setTshirts(result))
      .catch(console.log);
  }, []);

  function handleChange(evt) {
    const clone = { ...invoices };
    if (evt.target.name === "itemType") {
      clone["itemType"] =
        evt.target.options[evt.target.selectedIndex].getAttribute("data-type");
      clone["itemId"] =
        evt.target.options[evt.target.selectedIndex].getAttribute("data-id");
      console.log(clone);
    } else {
      clone[evt.target.name] = evt.target.value;
    }

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
            name="name"
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
          <label htmlFor="zipCode">zipCode</label>
          <input
            type="text"
            id="zipCode"
            name="zipCode"
            className="form-control"
            value={invoices.zipCode}
            onChange={handleChange}
          />
        </div>
        <div className="mb-3">
          <label htmlFor="itemType">Item Type</label>
          <select id="itemType" name="itemType" onChange={handleChange}>
            <optgroup label="Consoles">
              {consoles.map((c) => (
                <option data-type="Consoles" data-id={c.id}>
                  {c.manuacturer} {c.memoryAmount}
                  {c.processor}
                </option>
              ))}
            </optgroup>
            <optgroup label="Games">
              {games.map((g) => (
                <option data-type="Games" data-id={g.id}>
                  {g.title}
                  {g.studio}
                  {g.ersbRating}
                </option>
              ))}
            </optgroup>
            <optgroup label="Tshirts">
              {tshirts.map((t) => (
                <option data-type="Tshirts" data-id={t.id}>
                  {t.size}
                  {t.color}
                </option>
              ))}
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
