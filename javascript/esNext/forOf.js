for( let letras of 'Cod3r'){
    console.log(letras)
}

const assuntosECMA = ['Map', 'Set', 'Promise']

for (let i in assuntosECMA) {
    console.log(assuntosECMA[i])
}

for (let assuntos of assuntosECMA){
    console.log(assuntos)
}

const assuntosaMap = new Map([
    ['Map', {abordado: true}],
    ['Set', {abordado: true}],
    ['Promise', {abordado: false}],
])

for (let assuntos of assuntosaMap) {
    console.log(assuntos)
}

for (let chave of assuntosaMap.keys()){
    console.log(chave)
}


for (let valor of assuntosaMap.values()){
    console.log(valor)
}


for (let [ch, vl] of assuntosaMap.entries()){
    console.log(ch, vl)
}

const s = new Set(['a', 'b', 'c'])
for (let letra of s) {
    console.log(letra)
}