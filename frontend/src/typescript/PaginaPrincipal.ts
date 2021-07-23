
const botao = document.getElementById("botaoLogin");

botao.addEventListener('click', irPaginaLogin);


async function irPaginaLogin () {
  window.location.href = "../pages/login.html";

}

async function listarprodutos () {
  let token = "Bearer " + window.localStorage.getItem("token");
  // console.log(token);
  const rawResponse = await fetch('http://localhost:8080/api/leilao', {
    method: 'GET',
    headers: {
      'Content-Type': 'application/json',
      'Authorization': token
    }
  });
  rawResponse.json().then(t => console.log(t[0]));
}

listarprodutos();