const botao = document.getElementById("botaoLogin");
botao.addEventListener('click', irPaginaLogin);
async function irPaginaLogin() {
    window.location.href = "../pages/login.html";
}
async function listarprodutos() {
    const rawResponse = await fetch('http://localhost:8080/api/leilao', {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        }
    });
    renderizarProdutos(rawResponse.json());
}
function addListener(lista) {
    lista.forEach(elementLista => {
        let element = elementLista;
        element.addEventListener("mousemove", () => {
            element.style.borderStyle = "solid";
            element.style.borderColor = "#E7E7E7";
        });
        element.addEventListener("mouseleave", () => {
            element.style.border = null;
        });
        element.addEventListener("click", () => {
            window.localStorage.setItem("produto", element.getElementsByClassName("id").item(0).textContent);
            window.location.href = "../pages/telaLeilao.html";
        });
    });
}
function renderizarProdutos(json) {
    let catalogo = document.getElementById("catalogo");
    json.then(dados => {
        let i = 0;
        let html = "";
        while (true) {
            if (dados[i] === undefined) {
                break;
            }
            let elemento = dados[i++];
            console.log(elemento);
            html += `<div class="item_catalogo" id="item_catalogo">
      <div id="imagens" class="imagens"></div>
      <label id="id" class="id" for="">${elemento["id"]}</label>
      <label id="data_inicio" for="">${elemento["dataInicio"]}</label>
      <label id="valor_atual" for="">${elemento["valorAtual"]}</label>
      <label id="valor_inicial" for="">${elemento["valorInicial"]}</label>
      <label id="nome_ultimo_lance" for="">${elemento["usernameUltimoLance"]}</label>
      </div>`;
        }
        catalogo.innerHTML = html;
        addListener(catalogo.querySelectorAll('[id=item_catalogo]'));
    });
}
listarprodutos();
