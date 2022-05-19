import React from 'react';
import { Container } from "react-bootstrap";

function Home() {
  return (
    <Container className='container-home'>
      <h1 className='home-h1'>
        Welcome to the GameStore
      </h1>
      <div className='hompage-link-container'>
      <a className='homepage-link' 
        href='/games'>
        Games
      </a>
      <a className='homepage-link'
        href='/consoles'>
        Consoles
      </a>
      <a className='homepage-link'
        href='/tshirts'>
        Tshirts
      </a>
      </div>
    </Container>

  )
}

export default Home