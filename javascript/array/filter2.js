Array.prototype.filter2 = function(callback){
    const newArray = [];
    for (let i = 0; i < this.length; i++) {
        callback(this[i], i, this) ? newArray.push(this[i]) : null
    }
    return newArray
}

const produtos = [
    {nome: "Notebook", preco: 2499.99, fragil: true},
    {nome: "Ipad Prod", preco: 4499.99, fragil: true},
    {nome: "Copo de vidro", preco: 12.49, fragil: true},
    {nome: "Copo de plastico", preco: 18.49, fragil: false},
]

const produtoCaro = p => p.preco >= 500
const produtoFragil = p => p.fragil

console.log(produtos.filter2(produtoCaro).filter2(produtoFragil))