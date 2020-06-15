const express = require('express'); // web framework for building web aplication using node
const router = express.Router();
const bcrypt = require('bcryptjs');
const jwt = require('jsonwebtoken');
const User = require('../model/User');
const {registerInput}= require('../validation');

router.post('/register', (req, res, next) => {
   const {errors, isValid} = registerInput(req.body);
   if(!isValid){
       res.status(400).json(errors);
   }
let{ username, password, FirstName, lastName, roles } =req.body;
User.findOne({username}) 
.then((user) =>{
    if(user){
       throw new Error(' User already exists!'); 
    }
    bcrypt.hash(password, 10,(err, hash)=>{
        if(err)return  next(err);
        User.create({username, password:hash, FirstName, lastName, roles})
            .then((user) => {
                res.json({status:"Register Sucesss"});
            }).catch(next); 
        })
        }).catch(next); 
});

   

//res.send('testing');
router.post('/login', (req, res, next)=>{
   const{username, password}  = req.body;
   User.findOne({username})
   .then((user)=>{
  if(!user){
        let err = new Error(' User doesnot exists!');
       err.status = 400;
        return  next(err);
    }
    bcrypt.compare(password, user.password)
       .then((isMatched) => {
        if(!isMatched) {
            let err = new Error(' password doesnot match!');
           err.status = 400;
            return  next(err);
        }
        const payload={
            id: user._id,
            username:user.username,
            FirstName: user.FirstName,
            lastName:user.lastName,
            roles:user.roles
        }
        jwt.sign(payload, process.env.SECRET, {expiresIn: '4hr'},(err,token)=>{
            if(err) return  next(err);
            // throw new Error ('Token couldnot be created');
            res.json({message:'login sucessful' , token});
        })
       
       })
   }).catch(next);
})
   
module.exports = router;





 //     let err = new Error(' User already exists!');
    //    err.status = 401;
    //     return  next(err);
    // }
//     bcrypt.hash(password, 10)
//     .then(hash =>{
        // User.create({username, password:hash, FirstName, lastName})
        //     .then((user) => {
        //         res.json({status:"Register Sucesss"});
        //     }).catch(next); 
//     }).catch(next); 

    
// }).catch(next);   
// })