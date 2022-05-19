import React from "react";

import { Nav, Navbar, Container } from "react-bootstrap";

function NavbarApp(props) {
  return (
    <Navbar collapseOnSelect expand="md" bg="dark" variant="dark" fixed="top">
      <Container>
        <Navbar.Brand className="logo-link" href="/">
          <h2 className="logo">
          Game Store
          </h2>
          </Navbar.Brand>
        <Navbar.Toggle aria-controls="responsive-navbar-nav" />
        <Navbar.Collapse id="responsive-navbar-nav">
          <Nav className="justify-content-end" style={{ width: "100%" }}>
            <Nav.Link className="nav-link" eventKey={2} href="/games">
              Games
            </Nav.Link>
            <Nav.Link className="nav-link" eventKey={2} href="/consoles">
              Consoles
            </Nav.Link>
            <Nav.Link className="nav-link" eventKey={2} href="/tshirts">
              T-Shirts
            </Nav.Link>
          </Nav>
        </Navbar.Collapse>
      </Container>
    </Navbar>
  );
}

export default NavbarApp;
