classDiagram
direction BT
class airplanedata {
   varchar name
   integer capacity
   varchar id
}
class airport {
   varchar name
   varchar city
   varchar country
   varchar id
}
class customerdata {
   varchar firstname
   varchar lastname
   date dob
   varchar id
}
class flightdata {
   varchar routedatafrom
   varchar routedatatoo
   varchar etddatetime
   varchar etadatetime
   integer flightduration
   varchar airplaneid
   varchar id
}
class routedata {
   varchar fromm
   varchar too
   varchar id
}

routedata  -->  flightdata : id
