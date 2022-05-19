function ConsolesCard({ consoles, notify }) {
  function handleDelete() {
    fetch(`http://localhost:8080/consoles/${consoles.id}`, {
      method: "DELETE",
    })
      .then(() => notify({ action: "delete", consoles: consoles }))
      .catch((error) => notify({ action: "delete", error: error }));
  }

  return (
    <tr key={consoles.consolesId}>
      <td>{consoles.model}</td>
      <td>{consoles.manufacturer}</td>
      <td>{consoles.memoryAmount}</td>
      <td>{consoles.processor}</td>
      <td>{consoles.price}</td>
      <td>{consoles.quantity}</td>

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
          onClick={() => notify({ action: "edit-form", consoles: consoles })}
        >
          Edit
        </button>
      </td>
    </tr>
  );
}

export default ConsolesCard;
