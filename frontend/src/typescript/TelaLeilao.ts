let json = null;

document.getElementById("botaoLance").addEventListener("click", async () => {
    let valor = (document.getElementById("valorDoLance") as HTMLInputElement).value;
    
    if(json["valorAtual"] < parseFloat(valor)) {
        document.getElementById("valorDoLance").style.border = null;
        json["valorAtual"] = parseFloat(valor);
        json["usernameUltimoLance"] = window.localStorage.getItem("username");
        renderizarLeilaoJson();
    
        const rawResponse = await fetch('http://localhost:8080/api/leilao/update', {
            method: 'POST',
            headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            "Authorization": `Bearer ${window.localStorage.getItem("token")}`
            },
            body: JSON.stringify(json)
        });

    } else {
        document.getElementById("valorDoLance").style.border = "2px solid red";
    }
});

async function renderizarLeilao() {
    const rawResponse = await fetch(`http://localhost:8080/api/leilao/${window.localStorage.getItem("produto")}`, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
            "Authorization": `Bearer ${window.localStorage.getItem("token")}`
        }
    });
    if(rawResponse.status === 403) {
        window.location.href = "../pages/login.html";
    }else if(rawResponse.ok) {
        json = await rawResponse.json();
        let div = document.getElementById("divDados");

        let nomesProdutos = "";
        let nomeUltimoLance = json["usernameUltimoLance"];

        json["listaProdutos"].forEach(element => {
            nomesProdutos += `${element["nome"]}</br>`;
            
        });

        if(nomeUltimoLance === null) {
            nomeUltimoLance = "Sem Ninguém"
        }

        div.innerHTML = `<Label id="nomeDoProduto">${nomesProdutos}</Label>
        <label for="" id="DescricaoDoLeilao">${json["descricao"]}</label>
        <label for="" id="valorUltimoLance">R$${json["valorAtual"]}</label>
        <label for="" id="NomeDoUltimo">${nomeUltimoLance}</label>`;
        console.log(json);
    }
}

async function renderizarLeilaoJson() {
    let div = document.getElementById("divDados");

    let nomesProdutos = "";
    let nomeUltimoLance = json["usernameUltimoLance"];

    json["listaProdutos"].forEach(element => {
        nomesProdutos += `${element["nome"]}</br>`;
        
    });

    if(nomeUltimoLance === null) {
        nomeUltimoLance = "Sem Ninguém"
    }

    div.innerHTML = `<Label id="nomeDoProduto">${nomesProdutos}</Label>
    <label for="" id="DescricaoDoLeilao">${json["descricao"]}</label>
    <label for="" id="valorUltimoLance">R$${json["valorAtual"]}</label>
    <label for="" id="NomeDoUltimo">${nomeUltimoLance}</label>`;
}

renderizarLeilao();