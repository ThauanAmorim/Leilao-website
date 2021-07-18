
const botaoLogin = document.getElementById("botao-logar");
const botaoNaoTenhoConta = document.getElementById("botao-nao-tenho-conta");

botaoLogin.addEventListener('click', logar);
botaoNaoTenhoConta.addEventListener('click', irTelaCadastro);


async function logar () {
    const rawResponse = await fetch('http://localhost:8080/api/login', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify({username: (document.getElementById("usernameInput") as HTMLInputElement).value,
    senha: (document.getElementById("passwordInput") as HTMLInputElement).value})
  });
  if (rawResponse.ok) {
    document.getElementById("usernameInput").style.border = null;
    document.getElementById("passwordInput").style.border = null;
    const content = await rawResponse.json();
    window.localStorage.setItem("token", content["response"]);
  } else if(rawResponse.status == 400) {
    document.getElementById("usernameInput").style.border = "5px solid #ff0000";
    document.getElementById("passwordInput").style.border = "5px solid #ff0000";
    console.log(window.localStorage.getItem("token"));
    
  } else {
      console.log("algum erro maluco")
  }
}

function irTelaCadastro () {
  window.location.href = "../pages/Cadastrar.html";
}