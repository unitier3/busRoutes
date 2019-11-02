(ns projects.scenarios)

(def busRoutes00
  '{ :newcastle ({:location "middlesbrough" :cost 8} {:location "darlington" :cost 7} {:location "durham" :cost 6})
    :middlesbrough ({:location "redcar" :cost 2} {:location "hartlepool" :cost 2} {:location "northallerton" :cost 3} {:location "newcastle" :cost 5} {:location "leeds" :cost 5})
    :darlington ({:location "newcastle" :cost 6} {:location "middlesbrough" :cost 3} {:location "durham" :cost 4} {:location "northallerton" :cost 2} {:location "leeds" :cost 17})
    :durham ({:location "darlington" :cost 3} {:location "newcastle" :cost 6})
    :northallerton ({:location "durham" :cost 4} {:location "darlington" :cost 5})
    :leeds ({:location "manchester" :cost 18} {:location "york" :cost 6} {:location "wakefield" :cost 3})
    :manchester ({:location "liverpool" :cost 19} {:location "warrington" :cost 3} {:location "bolton" :cost 4})
    :liverpool ( {:location "warrington" :cost 2} {:location "manchester" :cost 7} {:location "chester" :cost 4})
    })


(def busRoutes01
  '{ :newcastle ({:location "middlesbrough" :cost 8} {:location "darlington" :cost 7} {:location "durham" :cost 6})
    :middlesbrough ({:location "redcar" :cost 2} {:location "hartlepool" :cost 2} {:location "northallerton" :cost 3} {:location "newcastle" :cost 5} {:location "leeds" :cost 5})
    :darlington ({:location "newcastle" :cost 6} {:location "middlesbrough" :cost 3} {:location "durham" :cost 4} {:location "northallerton" :cost 2} {:location "leeds" :cost 17})
    :durham ({:location "darlington" :cost 3} {:location "newcastle" :cost 6})
    :northallerton ({:location "durham" :cost 4} {:location "darlington" :cost 5})
    :york ( {:location "darlington" :cost 2} {:location "manchester" :cost 6}  {:location "leeds" :cost 2} {:location "newcastle" :cost 4} {:location "durham" :cost 3})
    :leeds ({:location "manchester" :cost 18} {:location "york" :cost 6} {:location "wakefield" :cost 3})
    :wakefield ({:location "liverpool" :cost 19} {:location "warrington" :cost 3} {:location "bolton" :cost 4} {:location "leeds" :cost 6})
    :manchester ({:location "liverpool" :cost 19} {:location "warrington" :cost 3} {:location "bolton" :cost 4})
    :liverpool ( {:location "warrington" :cost 2} {:location "manchester" :cost 7} {:location "chester" :cost 4})
    })



(def busRoutes02
  '{ :newcastle ({:location "middlesbrough" :cost 8} {:location "darlington" :cost 7} {:location "durham" :cost 6})
    :middlesbrough ({:location "redcar" :cost 2} {:location "hartlepool" :cost 2} {:location "northallerton" :cost 3} {:location "newcastle" :cost 5} {:location "leeds" :cost 5})
    })


(def busRoutes03
  '{
    :newcastle ({:location "middlesbrough" :cost 8} {:location "darlington" :cost 7} {:location "durham" :cost 6})
    :middlesbrough ({:location "redcar" :cost 2} {:location "hartlepool" :cost 2} {:location "northallerton" :cost 3} {:location "newcastle" :cost 5} {:location "leeds" :cost 5})
    :leeds ({:location "manchester" :cost 18} {:location "york" :cost 6} {:location "wakefield" :cost 3})
    :manchester ({:location "liverpool" :cost 19} {:location "warrington" :cost 3} {:location "bolton" :cost 4})
    :liverpool ( {:location "warrington" :cost 2} {:location "manchester" :cost 7} {:location "chester" :cost 4})
    })



(def busRoutes04
  '{
    :liverpool ( {:location "warrington" :cost 2} {:location "manchester" :cost 7} {:location "chester" :cost 4})
    })


(def busRoutes05
  '{
    :northallerton ({:location "durham" :cost 4} {:location "darlington" :cost 5})
    :darlington ({:location "newcastle" :cost 6} {:location "middlesbrough" :cost 3} {:location "durham" :cost 4} {:location "northallerton" :cost 2} {:location "leeds" :cost 17})

    })

(def busRoutes06
  '{
    :york ( {:location "darlington" :cost 2} {:location "manchester" :cost 6} {:location "newcastle" :cost 4} {:location "durham" :cost 3})
    :darlington ({:location "newcastle" :cost 6} {:location "middlesbrough" :cost 3} {:location "durham" :cost 4} {:location "northallerton" :cost 2} {:location "leeds" :cost 17})

    })

(def busRoutes07
  '{
    :liverpool ( {:location "warrington" :cost 2} {:location "manchester" :cost 7} {:location "chester" :cost 4})
    :manchester ({:location "liverpool" :cost 19} {:location "warrington" :cost 3} {:location "leeds" :cost 2} {:location "bolton" :cost 4})
    :leeds ( {:location "york" :cost 6} {:location "wakefield" :cost 3})
    :york ( {:location "darlington" :cost 2} {:location "manchester" :cost 6}  {:location "leeds" :cost 2} {:location "newcastle" :cost 4} {:location "durham" :cost 3})
    :darlington ({:location "newcastle" :cost 6} {:location "middlesbrough" :cost 3} {:location "durham" :cost 4} {:location "northallerton" :cost 2} {:location "leeds" :cost 17})

    })

(def busRoutes08
  '{
    :liverpool ( {:location "warrington" :cost 2} {:location "manchester" :cost 7} {:location "chester" :cost 4})
    :manchester ({:location "liverpool" :cost 19} {:location "warrington" :cost 3} {:location "leeds" :cost 2} {:location "bolton" :cost 4})
    :leeds ({:location "manchester" :cost 18} {:location "york" :cost 6} {:location "wakefield" :cost 3})
    :york ( {:location "darlington" :cost 2} {:location "manchester" :cost 6}  {:location "leeds" :cost 2} {:location "newcastle" :cost 4} {:location "durham" :cost 3})
    })

(def busRoutes09
  '{
    :darlington ({:location "newcastle" :cost 6} {:location "middlesbrough" :cost 3} {:location "durham" :cost 4} {:location "northallerton" :cost 2} {:location "leeds" :cost 17})
    :leeds ({:location "manchester" :cost 18} {:location "york" :cost 6} {:location "wakefield" :cost 3})
    :manchester ({:location "liverpool" :cost 19} {:location "warrington" :cost 3} {:location "bolton" :cost 4})
    })


(def busRoutes10
  '{
    :york ( {:location "darlington" :cost 2} {:location "manchester" :cost 6}  {:location "leeds" :cost 2} {:location "newcastle" :cost 4} {:location "durham" :cost 3})
    :leeds ({:location "manchester" :cost 18} {:location "york" :cost 6} {:location "wakefield" :cost 3})
    :manchester ({:location "liverpool" :cost 19} {:location "warrington" :cost 3} {:location "leeds" :cost 2} {:location "bolton" :cost 4})
    })

(def busRoutes11
  '{
    :newcastle ({:location "middlesbrough" :cost 8} {:location "darlington" :cost 7} {:location "durham" :cost 6})
    :durham ({:location "darlington" :cost 3} {:location "newcastle" :cost 6})
    :darlington ({:location "newcastle" :cost 6} {:location "middlesbrough" :cost 3} {:location "durham" :cost 4} {:location "northallerton" :cost 2} {:location "leeds" :cost 17})
    :middlesbrough ({:location "redcar" :cost 2} {:location "hartlepool" :cost 2} {:location "northallerton" :cost 3} {:location "newcastle" :cost 5} {:location "leeds" :cost 5})
    :leeds ({:location "manchester" :cost 18} {:location "york" :cost 6} {:location "wakefield" :cost 3})
    :york ( {:location "darlington" :cost 2} {:location "manchester" :cost 6}  {:location "leeds" :cost 2} {:location "newcastle" :cost 4} {:location "durham" :cost 3})
    :manchester ({:location "liverpool" :cost 19} {:location "warrington" :cost 3} {:location "leeds" :cost 2} {:location "bolton" :cost 4})
    :liverpool ( {:location "warrington" :cost 2} {:location "manchester" :cost 7} {:location "chester" :cost 4})

    })


(def busRoutes12
  '{
      :newcastle ({:location "middlesbrough" :cost 8} {:location "darlington" :cost 7} {:location "durham" :cost 6})
      :durham ({:location "darlington" :cost 3} {:location "newcastle" :cost 6} {:location "durham" :cost 4}   {:location "chesterlestreet" :cost 4} )
      :chesterlestreet   ({:location "darlington" :cost 3} {:location "newcastle" :cost 6})
      :darlington ({:location "newcastle" :cost 6} {:location "middlesbrough" :cost 3} {:location "durham" :cost 4} {:location "northallerton" :cost 2} {:location "leeds" :cost 17})
      :northallerton ({:location "darlington" :cost 3} {:location "newcastle" :cost 6} {:location "thirsk" :cost 1})
       :thirsk ({:location "northallerton" :cost 1} {:location "york" :cost 3} {:location "yarm" :cost 4})
      :yarm  ({:location "northallerton" :cost 4} {:location "york" :cost 6} {:location "thirsk" :cost 5})
      :york ( {:location "darlington" :cost 2}  {:location "scarborough" :cost 6}  {:location "manchester" :cost 6}  {:location "leeds" :cost 2} {:location "newcastle" :cost 4} {:location "durham" :cost 3} {:location "harrogate" :cost 2}{:location "doncaster" :cost 5})
      :scarborough    ({:location "leeds" :cost 10} {:location "york" :cost 5} {:location "whitby" :cost 1})
      :whitby        ({:location "scarborough" :cost 2} {:location "york" :cost 4} {:location "hull" :cost 4})
       :hull       ({:location "whitby" :cost 4} {:location "york" :cost 7})
       :doncaster   ({:location "leeds" :cost 6} {:location "york" :cost 7})
       :harrogate ({:location "leeds" :cost 5} {:location "york" :cost 2})
       :leeds ({:location "manchester" :cost 18} {:location "york" :cost 6} {:location "wakefield" :cost 3}{:location "sheffield" :cost 5})
       :sheffield       ({:location "manchester" :cost 9} {:location "york" :cost 6} {:location "leeds" :cost 3})
      :wakefield  ({:location "manchester" :cost 9} {:location "york" :cost 6} {:location "leeds" :cost 3})
      :manchester ({:location "liverpool" :cost 10} {:location "warrington" :cost 3} {:location "bolton" :cost 4})
      :warrington ({:location "manchester" :cost 3} {:location "bolton" :cost 4} {:location "liverpool" :cost 5})
      :bolton   ({:location "manchester" :cost 4} {:location "manchester" :cost 3} {:location "liverpool" :cost 4})
      :liverpool ( {:location "warrington" :cost 2} {:location "manchester" :cost 7} {:location "chester" :cost 4})


       })
