const jaTemConta = document.getElementById("botao-tem-conta-id");
const botaoCadastrar = document.getElementById("botao-cadastrar-id");
const inputsList = [];
jaTemConta.addEventListener('click', irTelaLogin);
botaoCadastrar.addEventListener('click', cadastrar);
popularListaInputs();
async function cadastrar() {
    if (validarCampos())
        return;
    window.localStorage.setItem("username", inputsList[0].value);
    window.localStorage.setItem("email", inputsList[1].value);
    window.localStorage.setItem("senha", inputsList[4].value);
    window.localStorage.setItem("cpf", inputsList[3].value);
    window.localStorage.setItem("dataNascimento", inputsList[2].value);
    window.location.href = "../pages/cadastrarEndereco.html";
}
function validarCampos() {
    let flag = false;
    inputsList.forEach(element => {
        if (element.value === "") {
            element.style.border = "5px solid red";
            flag = true;
        }
        else {
            element.style.border = null;
        }
    });
    if (inputsList[4].value != inputsList[5].value) {
        inputsList[4].style.border = "5px solid red";
        inputsList[5].style.border = "5px solid red";
        flag = true;
    }
    else {
        inputsList[4].style.border = null;
        inputsList[5].style.border = null;
    }
    return flag;
}
function popularListaInputs() {
    inputsList[0] = (document.getElementById("username"));
    inputsList[1] = (document.getElementById("email"));
    inputsList[2] = (document.getElementById("data"));
    inputsList[3] = (document.getElementById("cpf"));
    inputsList[4] = (document.getElementById("password"));
    inputsList[5] = (document.getElementById("confirmar-password"));
}
async function irTelaLogin() {
    window.location.href = "../pages/login.html";
}
