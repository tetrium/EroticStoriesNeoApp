<?php

namespace vanci_core\entities;

use vanci_core\libs\Common;
use vanci_core\libs\Globals;

/*

                                            SCHEMA

file:///C:\xampp\htdocs\vanci\vanci_db\schema\user_conversation_review.sql

 */

class UserConversationReviewData
{


    /**
     * @var int
     */
    public $userConversationReviewId;

    /**
     * @var string
     */
    public $userAccountId;


    /**
     * @var int
     */

    public $conversationId;

    /**
     * @var float
     */
    public $userConversationReviewRate;

    /**
     * @var string
     */
    public $userConversationReviewComment;
    /**
     * @var string
     */
    public $userConversationReviewDatetime;

    /**
     * @var UserAccountData
     */
    public $userAccount;

    /**
     * @var ConversationData
     */
    public $conversation;


    public static function getInstance($object): UserConversationReviewData
    {
        $object = Common::stdClassToClass($object, "vanci_core\\entities\\UserConversationReviewData");
        return $object;
    }
    function __construct()
    {
    }
}
