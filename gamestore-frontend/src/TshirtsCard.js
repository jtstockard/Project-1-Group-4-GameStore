function TshirtsCard({ tshirts, notify }) {
  function handleDelete() {
    fetch(`http://localhost:8080/tshirts/${tshirts.id}`, {
      method: "DELETE",
    })
      .then(() => notify({ action: "delete", tshirts: tshirts }))
      .catch((error) => notify({ action: "delete", error: error }));
  }

  return (
    <tr key={tshirts.tshirtsId}>
      <td>{tshirts.size}</td>
      <td>{tshirts.color}</td>
      <td>{tshirts.description}</td>
      <td>{tshirts.price}</td>
      <td>{tshirts.quantity}</td>
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
          onClick={() => notify({ action: "edit-form", tshirts: tshirts })}
        >
          Edit
        </button>
      </td>
    </tr>
  );
}

export default TshirtsCard;
