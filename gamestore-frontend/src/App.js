import Customers from "./Customer.js";
import OrderForm from "./OrderForm.js";
import Navbar from "./navbar";

function App() {
  return (
    <main className="container">
      <Navbar />
      <Customers />
    </main>
  );
}

export default App;
