const produtos = [
    {nome: "Notebook", preco: 2499.99, fragil: true},
    {nome: "Ipad Prod", preco: 4499.99, fragil: true},
    {nome: "Copo de vidro", preco: 12.49, fragil: true},
    {nome: "Copo de plastico", preco: 18.49, fragil: false},
]

console.log(produtos.filter(p => p.preco > 2500))

const produtoCaro = p => p.preco >= 500
const produtoFragil = p => p.fragil

console.log(produtos.filter(produtoCaro).filter(produtoFragil))