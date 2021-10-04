<?php

namespace vanci_core\entities;

use vanci_core\libs\Common;
use vanci_core\libs\Globals;

/*

                                            SCHEMA

file:///C:\xampp\htdocs\vanci\vanci_db\schema\user_account_role_action.sql

 */

class UserAccountRoleActionData
{
   
     /**
      * @var int
      */
      public $userAccountRoleActionId;

     /**
      * @var int
      */
     public $userAccountRoleId;

     /**
      * @var string
      */
     public $userAccountRoleName;

/**
      * @var int
      */
      public $userAccountActionId;

      /**
       * @var string
       */
      public $userAccountActionName;
     
     public static function getInstance($object): UserAccountRoleActionData
     {
          $object = Common::stdClassToClass($object, "vanci_core\\entities\\UserAccountRoleActionData");
          return $object;
     }
     function __construct()
     {
         
     }
}
