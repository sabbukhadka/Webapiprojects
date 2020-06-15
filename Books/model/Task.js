const mongoose = require('mongoose');
const noteSchema = new mongoose.Schema({
    
        text:{
            type: String,
            required:true
        },
        Date:{
            type: Date,
            default: Date.now
        }
    
});
const taskSchema = new mongoose.Schema({
    desc: {
        type: String,
        required: true
    },
    done: {
        type: Boolean,
        default: false
    },
    notes:[noteSchema],
    owner:{
        type: mongoose.Schema.Types.ObjectId,
        ref: ' user', //usermodel laii ref
        required:true
    }
        
    //     text:{
    //         type: String,
    //         required:true
    //     },
    //     Date:{
    //         type: Date,
    //         default: Date.now
    //     }
    // }]

        
    
}, { timestamps: true });
module.exports = mongoose.model('   Task', taskSchema);
// ,
    // category: {
    //     type: mongoose.Schema.Types.ObjectId,
    //     ref: 'Category',
    // },
    // author: {
    //     type: mongoose.Schema.Types.ObjectId,
    //     ref: 'User',
    //     required: true
    // },