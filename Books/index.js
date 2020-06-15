const express = require('express');
 const mongoose = require('mongoose'); // for crud operations object document mapper
 const auth = require('./auth')  ;
 require('dotenv').config();
 const taskRouter = require('./routes/taskRouter');
 const categoryRouter = require('./routes/categoryRouter');
 const userRouter = require('./routes/userRouter');

// app.use('/', routes);:27017
const app = express();

mongoose.connect('mongodb://127.0.0.1:27017/Bookstore',
{
   useNewUrlParser:true,
   useUnifiedTopology: true,
   useFindAndModify:true,
   useCreateIndex:true
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
app.use('/api/users', userRouter);
// app.use('/tasks', taskRouter);
 app.use('/api/tasks', auth.verifyUser,  taskRouter);
app.use('/api/categories', categoryRouter);

app.use((req,res,next)=>{
  let err = new Error('Not found');
  err.status =404;
  next(err);
  //res.status(404).json({status:'error', message:err.message});
})
app.use((err, req, res, next)=>{
  console.error(err.stack);
  res.status(err.status || 500);
  res.json({
    status:'error',
    message:err.message
  });
})

app.listen(process.env.Port, () => {
    console.log(`Server is running at localhost:${process.env.Port}`);
});








