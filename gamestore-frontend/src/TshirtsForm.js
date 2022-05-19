import { useState } from "react";

function TshirtsForm({ tshirts: initialTshirts, notify }) {
  const [tshirts, setTshirts] = useState(initialTshirts);
  const isAdd = initialTshirts.id === 0;

  function handleChange(evt) {
    const clone = { ...tshirts };
    clone[evt.target.name] = evt.target.value;
    setTshirts(clone);
  }

  function handleSubmit(evt) {
    evt.preventDefault();

    const url = isAdd
      ? "http://localhost:8080/tshirts"
      : `http://localhost:8080/tshirts/${tshirts.id}`;
    const method = isAdd ? "POST" : "PUT";
    const expectedStatus = isAdd ? 201 : 204;

    const init = {
      method,
      headers: {
        "Content-Type": "application/json",
        Accept: "application/json",
      },
      body: JSON.stringify(tshirts),
    };

    fetch(url, init)
      .then((response) => {
        if (response.status === expectedStatus) {
          if (isAdd) {
            return response.json();
          } else {
            return tshirts;
          }
        }
        return Promise.reject(
          `Didn't receive expected status: ${expectedStatus}`
        );
      })
      .then((result) =>
        notify({
          action: isAdd ? "add" : "edit",
          tshirts: result,
        })
      )
      .catch((error) => notify({ error: error }));
  }

  return (
    <>
      <h1>{tshirts.id > 0 ? "Edit" : "Add"} Tshirts</h1>
      <form onSubmit={handleSubmit}>
        <div className="mb-3">
          <label htmlFor="size">size</label>
          <input
            type="text"
            id="size"
            name="size"
            className="form-control"
            value={tshirts.size}
            onChange={handleChange}
          />
        </div>
        <div className="mb-3">
          <label htmlFor="color">color</label>
          <input
            type="text"
            id="color"
            name="color"
            className="form-control"
            value={tshirts.color}
            onChange={handleChange}
          />
        </div>
        <div className="mb-3">
          <textarea name="description" rows="10" cols="30">
            Was is it like
          </textarea>
        </div>
        <div className="mb-3">
          <label htmlFor="price">price</label>
          <input
            type="text"
            id="price"
            name="price"
            className="form-control"
            value={tshirts.price}
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
            value={tshirts.quantity}
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

export default TshirtsForm;
