function InvoiceCard({ invoice, notify }) {
  function handleDelete() {
    fetch(`http://localhost:8080/invoice/${invoice.invoiceId}`, {
      method: "DELETE",
    })
      .then(() => notify({ action: "delete", invoice: invoice }))
      .catch((error) => notify({ action: "delete", error: error }));
  }

  return (
    <tr key={invoice.invoiceId}>
      <td>{invoice.name}</td>
      <td>{invoice.street}</td>
      <td>{invoice.city}</td>
      <td>{invoice.state}</td>
      <td>{invoice.zipCode}</td>
      <td>{invoice.itemType}</td>
      <td>{invoice.itemId}</td>
      <td>{invoice.quantity}</td>
      <td>{invoice.total}</td>

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
          onClick={() => notify({ action: "edit-form", invoice: invoice })}
        >
          Edit
        </button>
      </td>
    </tr>
  );
}

export default InvoiceCard;
