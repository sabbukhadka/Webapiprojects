const express = require('express');
 const mongoose = require('mongoose'); // for crud operations
 const Task = require('./model/Task')

// const taskRouter = require('./routes/taskRouter');

// app.use('/', routes);:27017
const app = express();
mongoose.connect('mongodb://127.0.0.1/Bookstore',
{
   useNewUrlParser:true,
   useUnifiedTopology: true 
})
.then(() => console.log('Database server connected'))
  .catch(()=> console.log(err)) ;


    
// body bata aayeko data put data or post data pathayoo vanne we need 2 middleware
    app.use(express.json());
    // clientlee pathayeko data  server ma data read garna ko lagii
 app.use(express.urlencoded({ extended: false }));
  //form bata aayeko data read garnako lagii expreess throudg middle ware// query parameter req.params.id

app.get('/',(req,res,)=>{
    res.send(' weelcome to app');
});
// express web frame rus  on node
// client le pathayeko data chaii servere le kasarii read gar6, req.paramsid url ma
// two middle wares use 
//  app.use('/api/tasks',taskRouter);
//RESTFUL routes kunaii auta n point or route ma mutiple type ko request anusar lee  tesko response chaii faraka farka  parkar le garnee vanee apporach 6
// ma user anusar  server vayeko every resource laii user le faraka farka  method through modify manupuate , addresed garna pauune
app.get('/books',(req,res) => // client kun type kun browser bata aaye data hold for res object respone hamile pathaune data server hun6
{console.log(req);
    res.send ('Send all books');
});
app.post('/books',(req,res) => {
    console.log(req.body.desc);
     // for req :post req ma auane data client bata seve rsama body bataaau6
    res.status(201).send ('Should create a new  books');
});


app.put('/books',(req,res) => {
    res.send ('not supported');
});
app.delete('/books',(req,res) => {
    res.send ('Delete all books');
});
// parametrizedstring method banayo  , kunaii resouces banayo name same hunuparne  request method chaiii different banane

app.get('/books/:id',(req,res) => {
    res.send (`Send a books with id ${req.params.id} `);
});
app.put('/books/:id',(req,res) => {
    res.status(401).send ('not allowed');
});

app.post('/books/:id',(req,res) => {
    res.send ( `Update the books with id ${req.params.id} `); 
});

    app.delete('/books/:id',(req,res) => {
res.send (`Delete a  books with id ${req.params.id}`); 
});





app.listen(3000, () => {
    console.log('Server is running at localhost:3000');
});



/* const  Task = require('./model/Task');

// const categoryRouter = require('./routes/categories');
// const auth = require('./routes/auth');
// const userRouter = require('./routes/users');
// const dotenv = require('dotenv').config();
// const uploadRouter = require('./routes/upload');
// const cors = require('cors');
// const morgan = require('morgan');

// app.use(express.static(__dirname + "/public"));
// app.options('*', cors());
// app.use(cors());
// app.use(morgan('tiny'));






// //RESTFUL
// app.get((req,res,next) => {
//     Task.find({})
//     .then((tasks) => {
//         // res.statusCode = 200;
//         // res.setHeader('Content-Type', 'application/json');
//         res.json(tasks);
//     }, (err) => next(err))
//     .catch((err) => next(err));
// });
// app.post('/task', (req,res,next) =>{
//     Task.create(req.body)
//     .then((task)=>{
//         res.status(201).json(task);
//     }).catch((err) => next(err));
// });
// app.delete('/task', (req,res,next) =>{
//     Task.deleteMany()
//     .then((reply)=>{
//         res.json(reply);
//     }).catch((err) => next(err));
// })



// app.get('/task/:id',(req,res,next) => {
//     Task.findById(req.params.id)
//     .then((tasks) => {
//         res.json(task
//             );
//     }).catch(next);
// });
// app.put('/task/:id',(req,res,next) => {
//     Task.findByIdAndUpdate(req.params.id, { set: req.body}, {new:true})
//     .then((tasks) => {
//         res.json(task
//             );
//     }).catch(next);
// });

// app.delete('/task/:id',(req,res,next) => {
//     Task.findByIdAndDelete(req.params.id)
//     .then((reply) => {
// res.json(eply);
// }).catch(next);
// });






// app.use('/users', userRouter);
// app.use('/upload', auth.verifyUser, uploadRouter);
// app.use('/categories', auth.verifyUser, categoryRouter);
// app.use('/tasks', auth.verifyUser, taskRouter);

// app.use((err, req, res, next) => {
//     console.error(err.stack);
//     // res.status(500).send({ status: err.message });
//     res.statusCode = 500;
//     res.json({ status: err.message });
// })*/
// express web frame rus  on node
// client le pathayeko data chaii servere le kasarii read gar6, req.paramsid url ma
// two middle wares use 
//  app.use('/api/tasks',taskRouter);
//RESTFUL routes kunaii auta n point or route ma mutiple type ko request anusar lee  tesko response chaii faraka farka  parkar le garnee vanee apporach 6
// ma user anusar  server vayeko every resource laii user le faraka farka  method through modify manupuate , addresed garna pauune
// app.get('/task',(req,res) => // client kun type kun browser bata aaye data hold for res object respone hamile pathaune data server hun6
// {Task.find()
// .then((tasks)=>{
// res.json(tasks);
// }).catch(err =>console.log(err));
// });
// app.post('/task',(req,res) => {
//     Task.create(req.body)
//     .then((task)=>{
//         res.status(201).json(task);
//     }).catch((err) => console.log(err));
// });

// app.delete('/task',(req,res) => {
//    Task.deleteMany()
//    .then((reply)=>{
//    res.json(reply);
//    }).catch((err) => console.log(err));
// });
// // parametrizedstring method banayo  , kunaii resouces banayo name same hunuparne  request method chaiii different banane

// app.get('/task/:id',(req,res) => {
//     Task.findById(req.params.id)
//     .then((task)=>{
//         res.json(task);
//     }).catch((err) => console.log(err));
// });
// app.put('/task/:id',(req,res) => {
//     Task.findByIdAndUpdate(req.params.id, {$set: req.body}, {new: true})
//     .then((task)=>{
//     res.json(task);
// }).catch((err) => console.log(err));
// });

// // app.post('/books/:id',(req,res) => {
// //     res.send ( `Update the books with id ${req.params.id} `); 
// // });

//     app.delete('/task/:id',(req,res) => {
// Task.findByIdAndDelete(req.params.id)
// .then((reply)=>{
//     res.json(reply);
// }).catch((err) => console.log(err));
// });
