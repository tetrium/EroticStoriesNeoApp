<?php

namespace vanci_core\entities;

use vanci_core\libs\Common;
use vanci_core\libs\Globals;

/*

                                            SCHEMA

file:///C:\xampp\htdocs\vanci\vanci_db\schema\user_event.sql

 */

class UserNavigationLogData
{


     /**
      * @var int
      */
     public $userNavigationLogId;

     /**
      * @var string
      */
     public $userAccountId;

     /**
      * @var string
      */
     public $userEventId;
     /**
      * @var int
      */

     public $elementId;

     /**
      * @var string
      */
     public $userNavigationLogDatetime;
    /**
      * @var UserEventData
      */
      public $uerEventData;


     public static function getInstance($object): UserNavigationLogData
     {
          $object = Common::stdClassToClass($object, "vanci_core\\entities\\UserNavigationLogData");
          return $object;
          
     }
     function __construct()
     {
     }
}
