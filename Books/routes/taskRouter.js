const express = require('express');
const Task = require('../model/Task');
const auth = require('../auth')  ;
const router = express.Router();

  router.route('/')
    .get( (req, res, next) => {
        Task.find({owner: req.user.id})
            .then((task) => {
                res.json(task);
            }).catch(next);
    })

    .post((req, res, next) => {
        // console.log(req.user.id);
        // console.log(req.user);
        let {desc, done} =req.body;
        let owner = req.user.id;
        Task.create({desc,done,owner})
        // Task.create(req.body)
            .then((task) => { // then vitrakotask its objects
                res.status(201).json(task);
            }).catch(next);
    })
    .delete(auth.verifyAdmin, (req, res, next) => {
        Task.deleteMany() //{owner:req.user.id}
            .then((reply) => {
                res.json(reply);
            }).catch(next);
    });
     router.route('/:task_id')
    .get((req, res, next) => {
        Task.findById(req.params.task_id)
            .then((task) => {
                res.json(task);
            }).catch(next);
    })
    .put((req, res, next) => {
        Task.findByIdAndUpdate(req.params.task_id, { $set: req.body }, { new: true }) // update new thing dekhauu
            .then((task) => {
                res.json(task);
            }).catch(next);
        })
        .delete((req, res, next) => {
            Task.deleteOne({_id: req.params.task_id})//asynchro
                .then((reply) => {
                 res.json(reply);
                        
                }).catch(next);
        })
         router.route('/:task_id/notes')
         .get((req, res, next)=>{
             Task.findById(req.params.task_id)
             .then(task=>{
                 res.json(task.notes);
             }).catch(next);
         })
         .post((req, res, next)=>{
             Task.findById(req.params.task_id)
             .then((task)=>{
                 task.notes.push(req.body);
                 task.save()
                 .then((updatedTask)=>{
                    res.json(updatedTask.notes);
                }).catch(next);
        }).catch(next);
               
         })
       
        
        .delete((req, res, next) => {
            Task.findById(req.params.task_id)
                .then((task) => {
                    task.notes=[];
                    task.save()
                        .then((updatedTask) => {
                            res.json(updatedTask.notes);
                        }).catch(next);
                }).catch(next);
        })

        router.route('/:task_id/notes/:note_id')
        .get((req, res, next) => {
            Task.findById(req.params.task_id)
            .then(task=>{
                res.json(task.notes.id(req.params.note_id));
         }).catch(next);
        })
        .put((req, res, next)=> {
            Task.findById(req.params.task_id)
            .then(task=>{
           let note = task.notes.id(req.params.note_id);
           note.text = req.body.text;
                task.save()
                        .then(updatedTask => {
                            res.json(task.notes.id(req.params.note_id));
                        }).catch(next);

                     }).catch(next);
        })
        .delete((req, res, next)=>{
            Task.findById(req.params.task_id)
            .then(task=>{
                task.notes = task.notes.filter((note)=>{
                    return note.id !== req.params.note_id;
                })
                task.save()
                .then(updatedTask=>{
                    res.json(task.notes);
                }).catch(next);

            }).catch(next);
        })
    


    module.exports = router;

//.map, .filter, .radius
    // .post((req, res, next) => { if user wanted to create new task, 
    // put ko lagiiuserwant to change update edit garna lageko 6 vanee attributes but the content is same
    //     req.body.author = req.user._id;
    //     Task.create(req.body)
    //         .then((task) => {
    //             res.json(task);
    //         }).catch(next);
    // })
    // .delete((req, res, next) => {
    //     Task.deleteMany({ author: req.user._id })
    //         .then((status) => {
    //             res.json(status);
    //         }).catch(next);
    // });

// router.route('/:id')
//     .get((req, res, next) => {
//         Task.findById(req.params.id)
//             .populate('category', 'name')
//             .then((task) => {
//                 res.json(task);
//             }).catch(next);
//     })
//     .put((req, res, next) => {
//         Task.findByIdAndUpdate(req.params.id, { $set: req.body }, { new: true })
//             .then((task) => {
//                 res.json(task);
//             }).catch(next);
//     })
//     .delete((req, res, next) => {
//         Task.findByIdAndDelete(req.params.id)
//             .then((task) => {
//                 res.json(task);
//             }).catch(next);
//     });
// // HW for this thursday
// router.route('/:id/notes')
    // .get((req, res, next) => {
    //     Task.findById(req.params.id)
    //         .then((task) => {
    //             res.json(task.notes);
    //         }).catch(next);
    // })
    // .post((req, res, next) => {
    //     Task.findById(req.params.id)
    //         .then((task) => {
    //             // task.notes.push(req.body);
    //             task.notes.unshift(req.body);
    //             task.save()
    //                 .then((task) => {
    //                     res.json(task);
    //                 })
    //         }).catch(next);
    // })
//     .delete((req, res, next) => {
//         Task.findById(req.params.id)
//             .then((task) => {
//                 task.notes = [];
//                 task.save()
//                     .then((task) => {
//                         res.json(task);
//                     })
//             }).catch(next);
//     });

// router.route('/:id/notes/:noteId')
//     .get((req, res, next) => {
//         Task.findById(req.params.id)
//             .then((task) => {
//                 let note = task.notes.id(req.params.noteId);
//                 res.json(note);
//             }).catch(next);
//     })
//     .put((req, res, next) => {
//         Task.findById(req.params.id)
//             .then((task) => {
//                 let note = task.notes.id(req.params.noteId);
//                 note.desc = req.body.desc;
//                 task.save()
//                     .then((task) => {
//                         res.json(task.notes);
//                     })
//             }).catch(next);
//     })
//     // HW for tomorrow
    // .delete((req, res, next) => {
    //     Task.findById(req.params.id)
    //         .then((task) => {
    //             task.notes.pull(req.params.noteId);
    //             task.save()
    //                 .then((task) => {
    //                     res.json(task);
    //                 })
    //         }).catch(next);
    // });

