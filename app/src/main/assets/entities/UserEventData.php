<?php

namespace vanci_core\entities;

use vanci_core\libs\Common;
use vanci_core\libs\Globals;

/*

                                            SCHEMA

file:///C:\xampp\htdocs\vanci\vanci_db\schema\user_event.sql

 */

class UserEventData
{


     /**
      * @var int
      */
     public $userEventId;

     /**
      * @var string
      */
     public $userEventName;


     /**
      * @var int
      */

     public $entityId;

     /**
      * @var string
      */
     public $userEventDescription;

     
     public static function getInstance($object): UserEventData
     {
          $object = Common::stdClassToClass($object, "vanci_core\\entities\\UserEventData");
          return $object;
     }
     function __construct()
     {
          
     }
}
