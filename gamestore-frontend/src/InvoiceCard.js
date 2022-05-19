// import "./Card.css";

function InvoiceCard({ invoices, notify }) {
  function handleDelete() {
    fetch(`http://localhost:8080/invoices/${invoices.id}`, {
      method: "DELETE",
    })
      .then(() => notify({ action: "delete", invoices: invoices }))
      .catch((error) => notify({ action: "delete", error: error }));
  }

  return (
    <tr key={invoices.invoicesId}>
      <td>{invoices.name}</td>
      <td>{invoices.street}</td>
      <td>{invoices.city}</td>
      <td>{invoices.state}</td>
      <td>{invoices.zipCode}</td>
      <td>{invoices.itemType}</td>
      <td>{invoices.itemId}</td>
      <td>{invoices.unitPrice}</td>
      <td>{invoices.subTotal}</td>
      <td>{invoices.taxTotal}</td>
      <td>{invoices.processing}</td>
      <td>{invoices.quantity}</td>
      <td>{invoices.total}</td>
      <td>
        <button
          id="deleteButton"
          className="btn btn-danger mr-3"
          type="button"
          onClick={handleDelete}
        >
          Delete
        </button>
        <button
          id="editButton"
          className="btn btn-secondary"
          type="button"
          onClick={() => notify({ action: "edit-form", invoices: invoices })}
        >
          Edit
        </button>
      </td>
    </tr>
  );
}

export default InvoiceCard;
