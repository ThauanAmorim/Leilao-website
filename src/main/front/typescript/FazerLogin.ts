
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
    document.getElementById("usernameInput").style.border = null;
    document.getElementById("passwordInput").style.border = null;
    const content = await rawResponse.json();
    console.log(content);
  } else if(rawResponse.status == 400) {
    document.getElementById("usernameInput").style.border = "5px solid #ff0000";
    document.getElementById("passwordInput").style.border = "5px solid #ff0000";
  } else {
      console.log("algum erro maluco")
  }
}