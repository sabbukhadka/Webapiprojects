const jwt = require('jsonwebtoken');

const verifyUser =(req, res, next)=>{
console.log(req.headers.authorization);
let authHeader = req.headers.authorization;
if(!authHeader){
    let err = new Error(' No authentication informations');
    err.status =401;
    return  next(err);
}
let token = authHeader.split(" ")[1];
jwt.verify (token, process.env.SECRET,(err, payload)=>{
    if(err)return  next(err);
    //  console.log(payload);
     req.user =payload;
      next();
})

 }
 const verifyManager =(req, res, next)=>{
     if(!req.user){
        let err = new Error(' No authentication informations not provided');
        err.status =401;
        return  next(err);
     }
     if(req.user.roles =='manager'){
         return next();
     }
        let err = new Error(' Forbidden ');
        err.status =403;
        return  next(err);
    }

        const verifyAdmin =(req, res, next)=>{
            if(!req.user){
               let err = new Error(' No authentication informations not provided');
               err.status =401;
               return  next(err);
            }
            if(req.user.roles ==!'admin'){
                 return next();
            }
               let err = new Error(' Forbidden ');
               err.status =403;
               return  next(err);
        }
 
module.exports ={
    verifyUser,
     verifyManager,
     verifyAdmin
}
 // console.log(payload);