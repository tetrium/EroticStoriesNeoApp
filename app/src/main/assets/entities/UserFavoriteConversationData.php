<?php

namespace vanci_core\entities;

use vanci_core\libs\Common;
use vanci_core\libs\Globals;

/*

                                            SCHEMA

file:///C:\xampp\htdocs\vanci\vanci_db\schema\user_favorite_conversation.sql

 */

class UserFavoriteConversationData
{


     /**
      * @var int
      */
     public $userFavoriteConversationId;

     /**
      * @var string
      */
     public $userFavoriteConversationName;


     /**
      * @var int
      */

     public $entityId;

     /**
      * @var string
      */
     public $userFavoriteConversationDescription;

     
     public static function getInstance($object): UserFavoriteConversationData
     {
          $object = Common::stdClassToClass($object, "vanci_core\\entities\\UserFavoriteConversationData");
          return $object;
     }
     function __construct()
     {
          
     }
}
