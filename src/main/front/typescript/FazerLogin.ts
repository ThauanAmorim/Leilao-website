
const botaoLogin = document.getElementById("botao-logar");

botaoLogin.addEventListener('click', logar);

function logar () : void {
    console.log("clicado")
    window.location.href = "../pages/Cadastrar.html";

}