<?php

namespace vanci_core\entities;

use vanci_core\libs\Common;
use vanci_core\libs\Globals;

/*

                                            SCHEMA

file:///C:\xampp\htdocs\vanci\vanci_db\schema\user_conversation_statistics.sql

 */

class UserConversationStatisticsData
{

     /**
      * @var int
      */
     public $userConversationStatisticsId;

     /**
      * @var string
      */
     public $userAccountId;


     /**
      * @var int
      */

     public $conversationId;

     /**
      * @var int
      */
     public $currentConversationChapterId;

     /**
      * @var string
      */
     public $currentConversationSentenceId;

     /**
      * @var float
      */
     public $percentageProgress;

     public static function getInstance($object): UserConversationStatisticsData
     {
          $object = Common::stdClassToClass($object, "vanci_core\\entities\\UserConversationStatisticsData");
          return $object;
     }
     function __construct()
     {
     }
}
