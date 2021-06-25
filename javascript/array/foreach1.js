const aprovados = ['Ana', 'Bia', 'Carol', 'Dani']

aprovados.forEach((nome, indice) => {
    console.log(`${indice + 1} - ${nome}`)
})

aprovados.forEach((nome) => console.log(nome))

const exibirAprovados = aprovado => console.log(aprovado)

aprovados.forEach(exibirAprovados)