const botaoAdicionarEndereco = document.getElementById("botaoEndereco");
const inputsListEndereco = [];

botaoAdicionarEndereco.addEventListener('click', cadastrarEndereco);

popularListaInputsEndereco();

async function cadastrarEndereco () {
    if(validarCamposEndereco()) return;
  
    const rawResponse = await fetch('http://localhost:8080/api/user', {
      method: 'POST',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },
      body: JSON.stringify({
        username : window.localStorage.getItem("username"),
        email : window.localStorage.getItem("email"),
        senha : window.localStorage.getItem("senha"),
        cpf : window.localStorage.getItem("cpf"),
        dataNascimento : window.localStorage.getItem("dataNascimento"),
        endereco: {
            rua : inputsListEndereco[0].value,
            numero : inputsListEndereco[1].value,
            bairro : inputsListEndereco[2].value,
            cep : inputsListEndereco[3].value,
            cidade : inputsListEndereco[4].value,
            complemento : inputsListEndereco[7].value,
            estado : inputsListEndereco[5].value,
            pais : inputsListEndereco[6].value
        }})
    });
  
    if (rawResponse.ok) {
        window.localStorage.removeItem("username");
        window.localStorage.removeItem("email");
        window.localStorage.removeItem("senha");
        window.localStorage.removeItem("cpf");
        window.localStorage.removeItem("dataNascimento");

        window.location.href = "../pages/login.html";
      
    } else {
        console.log("algum erro maluco");
    }
}

function validarCamposEndereco() : boolean {
    let flag = false;
    
    inputsListEndereco.forEach(element => {
      if(element.value === "") {
        (element as HTMLInputElement).style.border = "5px solid red";
        flag = true;
      } else {
        element.style.border = null;
      }
    });
  
    if(inputsListEndereco[4].value != inputsListEndereco[5].value) {
        inputsListEndereco[4].style.border = "5px solid red";
        inputsListEndereco[5].style.border = "5px solid red";
      flag = true;
    } else {
        inputsListEndereco[4].style.border = null;
        inputsListEndereco[5].style.border = null;
  
    }
    
    return flag;
  }

function popularListaInputsEndereco() {
    inputsListEndereco[0] = (document.getElementById("logradouro"));
    inputsListEndereco[1] = (document.getElementById("numero"));
    inputsListEndereco[2] = (document.getElementById("bairro"));
    inputsListEndereco[3] = (document.getElementById("cep"));
    inputsListEndereco[4] = (document.getElementById("municipio"));
    inputsListEndereco[5] = (document.getElementById("estado"));
    inputsListEndereco[6] = (document.getElementById("pais"));
    inputsListEndereco[7] = (document.getElementById("complemento"));
}