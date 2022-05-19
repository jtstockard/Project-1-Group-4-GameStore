import Invoices from "./Invoice.js";
import Games from "./Games";
import Consoles from "./Consoles";
import Tshirts from "./Tshirts";
import Navbar from "./navbar";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";

function App() {
  return (
    <main className="container">
      <Navbar />
      <Router>
        <Switch>
          <Route exact path="/">
            <Invoices />
          </Route>
          <Route exact path="/games">
            <Games />
          </Route>
          <Route exact path="/consoles">
            <Consoles />
          </Route>
          <Route exact path="/tshirts">
            <Tshirts />
          </Route>
        </Switch>
      </Router>
    </main>
  );
}

export default App;
