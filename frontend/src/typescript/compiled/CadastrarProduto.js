const enviarProduto = document.getElementById("botao-enviar");
const inputsListProdutos = [];
enviarProduto.addEventListener('click', cadastrarProduto);
async function listarCategorias() {
    const rawResponse = await fetch('http://localhost:8080/api/categoria', {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
            "Authorization": `Bearer ${window.localStorage.getItem("token")}`
        }
    });
    renderizarCategorias(rawResponse.json());
}
function renderizarCategorias(json) {
    let categoria = document.getElementById("categoria");
    json.then(dados => {
        let i = 0;
        let html = "";
        while (true) {
            if (dados[i] === undefined) {
                break;
            }
            let elemento = dados[i++];
            console.log(elemento);
            html += `<option value=${elemento["id"]}>${elemento["categoriaNome"]}</option>`;
        }
        categoria.innerHTML = html;
    });
}
async function cadastrarProduto() {
    if (validarCamposProdutos())
        return;
    const rawResponse = await fetch('http://localhost:8080/api/user', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            username: window.localStorage.getItem("username"),
            email: window.localStorage.getItem("email"),
            senha: window.localStorage.getItem("senha"),
            cpf: window.localStorage.getItem("cpf"),
            dataNascimento: window.localStorage.getItem("dataNascimento"),
            endereco: {
                rua: inputsListEndereco[0].value,
                numero: inputsListEndereco[1].value,
                bairro: inputsListEndereco[2].value,
                cep: inputsListEndereco[3].value,
                cidade: inputsListEndereco[4].value,
                complemento: inputsListEndereco[7].value,
                estado: inputsListEndereco[5].value,
                pais: inputsListEndereco[6].value
            }
        })
    });
    if (rawResponse.ok) {
        window.location.href = "../pages/main.html";
    }
    else {
        console.log("algum erro maluco");
    }
}
function validarCamposProdutos() {
    let flag = false;
    inputsListProdutos.forEach(element => {
        if (element.value === "") {
            element.style.border = "5px solid red";
            flag = true;
        }
        else {
            element.style.border = null;
        }
    });
    return flag;
}
function popularListaInputsProdutos() {
    inputsListProdutos[0] = (document.getElementById("nome"));
    inputsListProdutos[0] = (document.getElementById("valor"));
    inputsListProdutos[0] = (document.getElementById("descricao"));
    inputsListProdutos[0] = (document.getElementById("categoria"));
}
listarCategorias();
