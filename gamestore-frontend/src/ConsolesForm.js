import { useState } from "react";

function ConsolesForm({ consoles: initialConsoles, notify }) {
  const [consoles, setConsoles] = useState(initialConsoles);
  const isAdd = initialConsoles.id === 0;

  function handleChange(evt) {
    const clone = { ...consoles };
    clone[evt.target.name] = evt.target.value;
    setConsoles(clone);
  }

  function handleSubmit(evt) {
    evt.preventDefault();

    const url = isAdd
      ? "http://localhost:8080/consoles"
      : `http://localhost:8080/consoles/${consoles.id}`;
    const method = isAdd ? "POST" : "PUT";
    const expectedStatus = isAdd ? 201 : 204;

    const init = {
      method,
      headers: {
        "Content-Type": "application/json",
        Accept: "application/json",
      },
      body: JSON.stringify(consoles),
    };

    fetch(url, init)
      .then((response) => {
        if (response.status === expectedStatus) {
          if (isAdd) {
            return response.json();
          } else {
            return consoles;
          }
        }
        return Promise.reject(
          `Didn't receive expected status: ${expectedStatus}`
        );
      })
      .then((result) =>
        notify({
          action: isAdd ? "add" : "edit",
          consoles: result,
        })
      )
      .catch((error) => notify({ error: error }));
  }

  return (
    <>
      <h1>{consoles.id > 0 ? "Edit" : "Add"} Consoles</h1>
      <form onSubmit={handleSubmit}>
        <div className="mb-3">
          <label htmlFor="model">model</label>
          <input
            type="text"
            id="model"
            name="model"
            className="form-control"
            value={consoles.model}
            onChange={handleChange}
          />
        </div>
        <div className="mb-3">
          <label htmlFor="manufacturer">manufacturer</label>
          <input
            type="text"
            id="manufacturer"
            name="manufacturer"
            className="form-control"
            value={consoles.manufacturer}
            onChange={handleChange}
          />
        </div>
        <div className="mb-3">
          <label htmlFor="memoryAmount">memoryAmount</label>
          <input
            type="text"
            id="memoryAmount"
            name="memoryAmount"
            className="form-control"
            value={consoles.memoryAmount}
            onChange={handleChange}
          />
        </div>
        <div className="mb-3">
          <label htmlFor="processor">processor</label>
          <input
            type="text"
            id="processor"
            name="processor"
            className="form-control"
            value={consoles.processor}
            onChange={handleChange}
          />
        </div>
        <div className="mb-3">
          <label htmlFor="price">price</label>
          <input
            type="text"
            id="price"
            name="price"
            className="form-control"
            value={consoles.price}
            onChange={handleChange}
          />
        </div>
        <div className="mb-3">
          <label htmlFor="quantity">quantity</label>
          <input
            type="text"
            id="quantity"
            name="quantity"
            className="form-control"
            value={consoles.quantity}
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

export default ConsolesForm;
