const enviarProduto = document.getElementById("botao-enviar");
const inputsListProdutos = [];
enviarProduto.addEventListener('click', cadastrarProduto);

// async function listarCategorias () {
//   const rawResponse = await fetch('http://localhost:8080/api/categoria', {
//     method: 'GET',
//     headers: {
//       'Content-Type': 'application/json',
//       "Authorization": `Bearer ${window.localStorage.getItem("token")}`
//     }
//   });
//   renderizarCategorias(rawResponse.json());
// }

// function renderizarCategorias(json : Promise<any>) {
//   let categoria = document.getElementById("categoria")
//   json.then(dados => {
//     let i = 0;
//     let html = "";
//     while(true) {
//       if(dados[i] === undefined) {
//         break;
//       }
//       let elemento = dados[i++];
//       console.log(elemento);
//       html += `<option value=${elemento["id"]}>${elemento["categoriaNome"]}</option>`;
//     }
//     categoria.innerHTML = html;
//   })
// }

async function cadastrarProduto () {
    if(validarCamposProdutos()) return;
  
    const rawResponse = await fetch('http://localhost:8080/api/produtos-leiloar', {
      method: 'POST',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
        "Authorization": `Bearer ${window.localStorage.getItem("token")}`
      },
      body: JSON.stringify({
        nome : inputsListProdutos[0].value})
    });
  
    if (rawResponse.ok) {
        window.location.href = "../pages/main.html";
      
    } else {
        console.log("algum erro maluco");
    }
}

function validarCamposProdutos() : boolean {
    let flag = false;
    
    inputsListProdutos.forEach(element => {
      if(element.value === "") {
        (element as HTMLInputElement).style.border = "5px solid red";
        flag = true;
      } else {
        element.style.border = null;
      }
    });
    
    return flag;
  }

function popularListaInputsProdutos() {
    inputsListProdutos[0] = (document.getElementById("nome"));
}

popularListaInputsProdutos();