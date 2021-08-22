const express = require('express')
const path = require('path')

const app = express()

app.set('view engine', 'ejs')
app.set('views', path.resolve(__dirname, 'pages'))

app.use(express.static('public'))
app.use(express.urlencoded({extended: true}))

const port = process.env.PORT ?? 3000

app.get('/', async (req, res) => {

    res.send("back 4 ok");

})

app.listen(port, () => console.log(`Server listening on port ${port}`))