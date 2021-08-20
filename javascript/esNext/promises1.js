let a = 1
console.log(a)

let p = new Promise((resolve, reject) => {
    resolve(['Ana', 'Bia', 'Carol', 'Dani'])
})

p.then(v => v[0]).then(console.log)
