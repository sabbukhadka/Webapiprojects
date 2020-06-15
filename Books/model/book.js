const mongoose = require('mongoose');
const bookSchema = new mongoose.Schema({
    
    title:{
		type: String,
		required: true
	},
	category:{
		type: String,
		required: true
	},
	description:{
		type: String
	},
	author:{
		type: String,
		required: true
	},
	publisher:{
		type: String
	},
	Isbn:{
		type:String
	},
	price: {
		type: Number,
		 required: true},
	pages:{
		type: String
	},
	image_url:{
		type: String
	},
	buy_url:{
		type: String
	},
	create_date:{
		type: Date,
		default: Date.now
	}
    },{timestamps:true})
    module.exports = mongoose.model('Books', bookSchema);
    

