const botaoLogin = document.getElementById("botao-logar");
const botaoNaoTenhoConta = document.getElementById("botao-nao-tenho-conta");
botaoNaoTenhoConta.addEventListener('click', irTelaCadastro);
botaoLogin.addEventListener('click', logar);
function validadorToken() {
    if (window.localStorage.getItem("token") !== 'null') {
        window.location.href = "../pages/main.html";
    }
}
async function logar() {
    const rawResponse = await fetch('http://localhost:8080/api/login', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ username: document.getElementById("usernameInput").value,
            senha: document.getElementById("passwordInput").value })
    });
    if (rawResponse.ok) {
        document.getElementById("usernameInput").style.border = null;
        document.getElementById("passwordInput").style.border = null;
        const content = await rawResponse.json();
        window.localStorage.setItem("token", content["response"]);
        window.localStorage.setItem("username", document.getElementById("usernameInput").value);
        window.location.href = "../pages/main.html";
    }
    else if (rawResponse.status == 400) {
        document.getElementById("usernameInput").style.border = "5px solid red";
        document.getElementById("passwordInput").style.border = "5px solid red";
    }
    else {
        console.log("algum erro maluco");
    }
}
async function irTelaCadastro() {
    window.location.href = "../pages/Cadastrar.html";
}
validadorToken();
