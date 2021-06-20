const botaoLogin = document.getElementById("botao-logar");
botaoLogin.addEventListener('click', logar);
function logar() {
    console.log("clicado");
    window.location.href = "../pages/Cadastrar.html";
}
