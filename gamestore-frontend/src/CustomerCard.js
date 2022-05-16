// Rename
function CustomerCard({ customer, notify }) {
  function handleDelete() {
    fetch(`http://localhost:8080/customer/${customer.customerId}`, {
      method: "DELETE",
    })
      .then(() => notify({ action: "delete", customer: customer }))
      .catch((error) => notify({ action: "delete", error: error }));
  }

  return (
    <tr key={customer.customerId}>
      <td>{customer.name}</td>
      <td>{customer.street}</td>
      <td>{customer.city}</td>
      <td>{customer.state}</td>
      <td>{customer.zip}</td>
      <td>{customer.itemType}</td>
      <td>{customer.itemId}</td>
      <td>{customer.quantity}</td>
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
          onClick={() => notify({ action: "edit-form", customer: customer })}
        >
          Edit
        </button>
      </td>
    </tr>
  );
}

export default CustomerCard;
