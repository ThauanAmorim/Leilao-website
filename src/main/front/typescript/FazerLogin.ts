
const botaoLogin = document.getElementById("botao-logar");

botaoLogin.addEventListener('click', logar);

async function logar () {
    //window.location.href = "../pages/Cadastrar.html";
    const rawResponse = await fetch('http://localhost:8080/api/login', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify({username: document.getElementById("usernameInput").value,
    senha: document.getElementById("passwordInput").value})
  });
  if (rawResponse.ok) {
    const content = await rawResponse.json();
    console.log(content);
  } else if(rawResponse.status == 400) {
      console.log("erro de login");
  } else {
      console.log("algum erro maluco")
  }
}