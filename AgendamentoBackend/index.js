const app = require("express")()
const http = require("http").createServer(app)

const bodyParser = require("body-parser")

app.use(bodyParser.json())

app.use(bodyParser.urlencoded({
    extended:true
}))

let agendamentos =[{
        "id": 1,
        "turma": "1º ano",
        "sala": "B02",
        "horario": "13:50",
        "apresentacao": "Teste",
        "classe": "Fund I"
        
        
    
    
}]

let idAgendamento = 1

app.get("/agendamentos", (req,res)=> res.send(agendamentos))


app.post("/novo", (req, res)=> {
    
    idAgendamento ++
    const turma = req.body.turma
    const sala = req.body.sala
    const horario = req.body.horario
    const apresentacao = req.body.apresentacao
    const classe = req.body.classe
    const id = idAgendamento
    
    const novoAgendamento = {
            id,
            turma,
            sala,
            horario,
            classe,
            apresentacao
        }
    
    agendamentos.push(novoAgendamento)
    res.send({"sucesso": true, "msg": "Adicinado com sucesso"})
    
})

app.get("/agendamento/:id",  (req, res)=>{
	
	const idAgendamento = req.params.id
	
	const agendamentosFiltrados = agendamentos
		.filter( agendamento =>  agendamento.id == idAgendamento )
		
	if(agendamentosFiltrados.length > 0){
		res.send(agendamentosFiltrados[0])	
	}else{
		res.send({})	
	}	
			
	
})




app.get("/",(req, res)=> {    
    res.send("Bem vindo a API")
})

http.listen(5001, ()=> {
    console.log("Server running on http://localhost:5001")
})