<?php

namespace vanci_core\entities;

use vanci_core\libs\Common;
use vanci_core\libs\Globals;

/*

                                            SCHEMA

file:///C:\xampp\htdocs\vanci\vanci_db\schema\conversation_category.sql

 */

class UserAccountRoleData
{


     /**
      * @var int
      */
     public $userAccountRoleId;

     /**
      * @var string
      */
     public $userAccountRoleName;


      /**
      * @var UserAccountRoleActionData[]
      */
      public $userAccountRoleActions;

     public static function getInstance($object): UserAccountRoleData
     {
          $object = Common::stdClassToClass($object, "vanci_core\\entities\\UserAccountRoleData");
          return $object;
     }
     function __construct()
     {
          
          $this->userAccountRoleActions=array();

         
     }
}
