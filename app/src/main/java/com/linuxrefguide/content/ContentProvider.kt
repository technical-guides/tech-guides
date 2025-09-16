package com.linuxrefguide.content

import com.linuxrefguide.NavigationState

object ContentProvider {
    fun getWelcomeMessage(): String = """
🐧 Welcome to the Linux Ref. Guide! 🐧

This interactive tutorial will guide you through essential Linux concepts,
from basic file operations to advanced system administration.

📖 What you'll learn:

• Basic Topics: File system navigation, file operations, viewing files, permissions
• Intermediate Topics: Process management, system monitoring, shell scripting, storage
• Advanced Topics: Kernel management, networking, security, virtualization

🎯 How to navigate:

• Use the sidebar menu to select a topic category
• Click or tap to navigate through menus and subtopics
• Use the back button (← Back) to return to previous menus

🚀 Getting Started:

Choose a topic category from the sidebar to explore subtopics and start learning!
Each section includes explanations, examples, and best practices.

Good luck on your Linux journey! 🎓
    """.trimIndent()

    fun getMenuContent(state: NavigationState): String {
        return when (state) {
            NavigationState.MAIN_MENU -> """
📚 Linux Ref. Guide

Select a category to begin:

📖 Basic Topics
Learn essential Linux fundamentals.

⚡ Intermediate Topics
Master system administration skills.

🚀 Advanced Topics
Dive into expert-level Linux mastery.

❌ Exit
Close the application.
            """.trimIndent()
            NavigationState.BASIC_SUBMENU -> """
📰 Basic Topics Menu

Select a subtopic to begin learning:

📁 File Commands
Learn essential file operations like creating, copying, moving, and deleting files.
Commands: touch, cp, mv, rm, mkdir

📂 Directory Navigation
Master navigating the Linux file system and understanding directory structures.
Commands: cd, ls, pwd, find, tree

👁️ File Viewing
Discover different ways to view and examine file contents.
Commands: cat, less, more, head, tail, grep

🔒 Permissions
Understand Linux file permissions and ownership concepts.
Commands: chmod, chown, chgrp, umask
            """.trimIndent()
            NavigationState.INTERMEDIATE_SUBMENU -> """
⚡ Intermediate Topics Menu

Select a subtopic to advance your Linux skills:

⚙️ Process Management
Master controlling and monitoring system processes, job control, and systemd.
Commands: ps, kill, killall, top, htop, systemctl, jobs, nohup

📊 System Monitoring
Learn performance analysis, resource monitoring, and log management.
Tools: iostat, vmstat, sar, journalctl, dmesg, free, df

💾 Storage & Filesystems
Advanced disk management, LVM, RAID, and filesystem optimization.
Topics: LVM, RAID, filesystem tuning, quotas, ACLs

💻 Shell Scripting
Write advanced bash scripts with functions, loops, and error handling.
Topics: Variables, functions, conditionals, loops, parameter expansion

👥 User Management
Understand user accounts, groups, sudo configuration, and PAM.
Commands: useradd, usermod, passwd, sudo, groups, id

📦 Package Management
Learn software installation, dependency management, and repository configuration.
Tools: apt, yum, dnf, snap, flatpak, rpm, dpkg

🌐 Network Basics
Basic network configuration, troubleshooting, and monitoring.
Commands: ip, netstat, ss, ping, traceroute, wget, curl
            """.trimIndent()
            NavigationState.ADVANCED_SUBMENU -> """
🚀 Advanced Topics Menu

Select a subtopic for expert-level Linux knowledge:

🔧 Kernel & Modules
Low-level system management, kernel compilation, and module development.
Commands: lsmod, modprobe, rmmod, modinfo, dkms, make menuconfig

🌐 Advanced Networking
Network security, traffic shaping, VPNs, and complex configurations.
Tools: iptables, tc, OpenVPN, WireGuard, netfilter, bridge-utils

🔐 Security Hardening
System security, mandatory access controls, and vulnerability mitigation.
Topics: SELinux, AppArmor, audit system, secure boot, hardening guides

🐳 Virtualization
Container technologies, orchestration, and virtual machine management.
Tools: Docker, Kubernetes, LXC, KVM, QEMU, libvirt

🏗️ High Availability
Clustering, load balancing, and fault-tolerant system design.
Tools: Pacemaker, Corosync, HAProxy, keepalived, DRBD

🔍 System Internals
Deep understanding of kernel internals, memory management, and debugging.
Topics: /proc, /sys, system calls, memory mapping, kernel debugging

⚡ Performance Tuning
System optimization, profiling, and advanced performance analysis.
Tools: perf, strace, ltrace, valgrind, SystemTap, eBPF
            """.trimIndent()
        }
    }

    fun getTopicContent(level: String, id: String): String {
        return when (level) {
            "basic" -> when (id) {
                "files" -> """
📁 File Commands - Basic File Operations

Essential commands for creating, copying, moving, and deleting files:

🆕 Creating Files and Directories:
• touch filename.txt - Create an empty file
• touch file1.txt file2.txt file3.txt - Create multiple files
• mkdir directory_name - Create a new directory
• mkdir -p path/to/nested/dirs - Create nested directories
• mkdir dir1 dir2 dir3 - Create multiple directories

📋 Copying Files and Directories:
• cp source.txt destination.txt - Copy a file
• cp source.txt /path/to/directory/ - Copy file to directory
• cp -r source_dir/ dest_dir/ - Copy directory recursively
• cp -i source.txt dest.txt - Interactive copy (ask before overwrite)
• cp -v source.txt dest.txt - Verbose copy (show what's happening)
• cp -p source.txt dest.txt - Preserve timestamps and permissions

🚚 Moving and Renaming:
• mv old_name.txt new_name.txt - Rename a file
• mv file.txt /path/to/directory/ - Move file to directory
• mv dir1/ /path/to/new/location/ - Move directory
• mv -i source.txt dest.txt - Interactive move (ask before overwrite)
• mv *.txt /backup/ - Move all .txt files to backup directory

🗑️ Removing Files and Directories:
• rm filename.txt - Remove a file
• rm file1.txt file2.txt - Remove multiple files
• rm -i filename.txt - Remove with confirmation prompt
• rm -r directory/ - Remove directory recursively
• rm -rf directory/ - Force remove directory (be careful!)
• rmdir empty_directory - Remove empty directory only
            """.trimIndent()
                "nav" -> """
📂 Directory Navigation - Moving Around the File System

Master the art of navigating Linux directories and file system:

🧭 Basic Navigation Commands:
• pwd - Print working directory (where am I?)
• cd directory_name - Change to a specific directory
• cd .. - Move up one directory level
• cd ../.. - Move up two directory levels
• cd ~ - Go to home directory
• cd / - Go to root directory
• cd - - Go to previous directory

📋 Listing Directory Contents:
• ls - List files and directories in current location
• ls -l - Long format listing with permissions and details
• ls -la - List all files including hidden ones (starting with .)
• ls -lh - List with human-readable file sizes
• ls -lt - Sort by modification time (newest first)
• ls -lS - Sort by file size (largest first)
            """.trimIndent()
                "view" -> """
👁️ File Viewing - Examining File Contents

Learn different ways to view and examine files safely and effectively:

📖 Basic File Viewing:
• cat filename.txt - Display entire file contents
• cat file1.txt file2.txt - Display multiple files
• cat -n filename.txt - Show line numbers
• tac filename.txt - Display file in reverse order
• less filename.txt - View file page by page (recommended)
• more filename.txt - Similar to less, but simpler
            """.trimIndent()
                "perms" -> """
🔒 Permissions - File and Directory Access Control

Understand Linux file permissions and ownership concepts:

🔐 Understanding Permissions:
• ls -l - Show permissions, owner, and group
• Permissions format: rwxr-xr-x (owner, group, others)
• r = read (4), w = write (2), x = execute (1)
• Example: rwxr-xr-x = 755 (owner: 7, group: 5, others: 5)
• - = regular file, d = directory, l = symbolic link
            """.trimIndent()
                else -> "Content for basic-$id not yet available."
            }
            "intermediate" -> when (id) {
                "process" -> """
⚙️ Process Management - Advanced Process Control

Master the art of managing system processes and services:

🔍 Process Monitoring:
• ps aux - Show all running processes with detailed info
• ps -ef - Alternative process listing format
• pstree - Display processes in tree format
• top - Real-time process monitor (interactive)
            """.trimIndent()
                else -> "Content for intermediate-$id not yet available."
            }
            "advanced" -> when (id) {
                "kernel" -> """
🔧 Kernel & Modules - Low-Level System Management

Master kernel management, module development, and system customization:

📋 Kernel Information:
• uname -r - Show kernel version
• cat /proc/version - Detailed kernel information
            """.trimIndent()
                else -> "Content for advanced-$id not yet available."
            }
            else -> "Content for $level-$id not yet available."
        }
    }
}