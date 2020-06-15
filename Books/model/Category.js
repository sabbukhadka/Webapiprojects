const mongoose = require('mongoose');

const categorySchema = new mongoose.Schema({
name:{
    type:String,
    required: true
},
tasks:[{
    type:mongoose.Schema.Types.ObjectId, //foreign key 1 to many side
    ref:'Task'
}]
},{timestamps:true})
module.exports = mongoose.model('Category', categorySchema);